package com.pets.cadillac;

public final class CadillacProfiles {

    // Spring profiles for development, test and production
    public static final String DEVELOPMENT = "dev";
    public static final String TEST = "test";
    public static final String PRODUCTION = "prod";
    // Spring profile used to disable swagger
    public static final String SWAGGER = "swagger";

    private CadillacProfiles() {
    }
}