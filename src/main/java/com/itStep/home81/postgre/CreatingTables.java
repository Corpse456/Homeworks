package com.itStep.home81.postgre;

import dataBase.postgre.PostgreSQL;
import workWithFiles.fileIO.ReaderFromFile;

import java.io.File;

public class CreatingTables {

    public static void main(String[] args) {
        PostgreSQL postgre = new PostgreSQL(Attributes.BASE_NAME);

        postgre.customQuery(Attributes.DELETE_SCHEMA);
        postgre.customQuery(Attributes.CREATE_SCHEMA);

        File[] folder = new File(Attributes.PATH).listFiles();
        for (File file : folder) {
            createTable(postgre, file);
        }

        postgre.close();
        System.out.println("Done");
    }

    private static void createTable(PostgreSQL postgre, File file) {
        ReaderFromFile reader = new ReaderFromFile(file);
        String query = reader.readAll();
        postgre.customQuery(query);
        reader.close();
    }
}
