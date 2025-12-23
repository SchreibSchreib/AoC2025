package com.aoc25.io.input.raw;

import com.aoc25.io.input.raw.api.InputSource;

public class RessourceInput implements InputSource {

    private final String _resourcePath;
    private final ClassLoader _classLoader;

    public RessourceInput(String resourcePath) {
        this(resourcePath, Thread.currentThread().getContextClassLoader());
    }

    public RessourceInput(String resourcePath, ClassLoader classLoader) {
        _resourcePath = resourcePath;
        _classLoader = classLoader;
    }

    @Override
    public String readInput() {
        try (var inputStream = _classLoader.getResourceAsStream(_resourcePath)) {
            if (inputStream == null) {
                throw new IllegalArgumentException("Resource not found: " + _resourcePath);
            }
            return new String(inputStream.readAllBytes());
        } catch (Exception e) {
            throw new RuntimeException("Failed to read resource: " + _resourcePath, e);
        }
    }
}
