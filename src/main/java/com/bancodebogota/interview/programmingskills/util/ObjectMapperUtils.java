package com.bancodebogota.interview.programmingskills.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Map objects from one class to another.
 * Permits also the mapping between lists
 * of different types
 *
 */
public class ObjectMapperUtils {

    private static ModelMapper modelMapper;

    /**
     * Creates a default mapper using Strict as the mapping strategy
     */
    static {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    /**
     * Hide constructor to avoid instances of this class
     */
    private ObjectMapperUtils() {
    }

    /**
     * <p>Note: targetClass object must have default constructor with no arguments</p>
     *
     * @param <D>         type of destination object.
     * @param <S>         type of source object to map from.
     * @param source      source object that needs to be mapped.
     * @param targetClass class of mapped/target object.
     * @return new object of <code>targetClass</code> type.
     */
    public static <D, S> D map(final S source, Class<D> targetClass) {
        return modelMapper.map(source, targetClass);
    }

    /**
     * <p>Note: targetClass object must have default constructor with no arguments</p>
     *
     * @param sourceList  list of entities that needs to be mapped
     * @param targetClass class of destination list elements
     * @param <D>         type of objects in destination list
     * @param <S>         type of objects in source list in
     * @return list of mapped object with <code><D></code> type.
     */
    public static <D, S> List<D> mapAll(final Collection<S> sourceList, Class<D> targetClass) {
        return sourceList.stream()
                .map(entity -> map(entity, targetClass))
                .collect(Collectors.toList());
    }

    /**
     * Maps {@code source} to {@code destination}.
     *
     * @param source      object to map from
     * @param destination object to map to
     */
    public static <S, D> D map(final S source, D destination) {
        modelMapper.map(source, destination);
        return destination;
    }
}