package com.ism.factory;

import com.ism.database.BDMemory;
import com.ism.database.Database;
import com.ism.database.DatabaseMemory;

enum PersistanceStrategy {
    MEMORY,
    BD
}
public final class DatabaseFactory {
    private static PersistanceStrategy strategy = PersistanceStrategy.MEMORY;

    public static Database createDatabase() {
        switch (strategy) {
            case MEMORY:
                return DatabaseMemory.getInstance();

            case BD:
                return BDMemory.getInstance();

            default:
                throw new IllegalArgumentException("Stratégie de persistance non valide");
        }
    }
}
