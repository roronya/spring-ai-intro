package org.example.springairag.config;

import org.springframework.ai.document.Document;
import org.springframework.ai.document.DocumentReader;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.reader.tika.TikaDocumentReader;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.util.List;

@Configuration
public class VectorStoreConfig {
    @Bean
    public SimpleVectorStore simpleVectorStore(EmbeddingModel embeddingModel, VectorStoreProperties vectorStoreProperties) {
        var store = SimpleVectorStore.builder(embeddingModel).build();
        File vectoreStoreFile = new File(vectorStoreProperties.getVectorStorePath());

        if (vectoreStoreFile.exists()) {
            store.load(vectoreStoreFile);
        } else {
            System.out.println("loading data...");
            vectorStoreProperties.getDocumentsToLoad().forEach(document -> {
                System.out.println("loading " + document.getFilename());
                DocumentReader documentReader = new TikaDocumentReader(document);
                List<Document> documents = documentReader.get();
                TokenTextSplitter tokenTextSplitter = new TokenTextSplitter();
                List<Document> splitDocs = tokenTextSplitter.apply(documents);
                store.add(splitDocs);
            });
            store.save(vectoreStoreFile);
        }
        return store;
    }
}
