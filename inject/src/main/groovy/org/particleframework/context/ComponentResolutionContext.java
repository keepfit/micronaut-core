package org.particleframework.context;

import org.particleframework.inject.*;

import java.util.Deque;
import java.util.Map;

/**
 * Represents the resolution context for a current resolve of a given bean
 *
 * @author Graeme Rocher
 * @since 1.0
 */
public interface ComponentResolutionContext {

    /**
     * @return The context
     */
    Context getContext();
    /**
     *
     * @return The class requested at the root of this resolution context
     */
    ComponentDefinition getRootDefinition();

    /**
     * @return The path that this resolution has taken so far
     */
    Path getPath();

    /**
     * @return The objects that are currently still being created
     */
    Deque<Object> getObjectsInCreation();

    /**
     * Represents a path taken to resolve a bean definitions dependencies
     */
    interface Path extends Deque<Segment> {
        /**
         * Push an unresolved constructor call onto the queue
         *
         * @param declaringType The type
         * @param argument The unresolved argument
         * @return This path
         */
        Path pushContructorResolve(ComponentDefinition declaringType, Argument argument);


        /**
         * Push an unresolved method call onto the queue
         *
         * @param declaringType The type
         * @param methodInjectionPoint The method injection point
         * @param argument The unresolved argument
         * @return This path
         */
        Path pushMethodArgumentResolve(ComponentDefinition declaringType, MethodInjectionPoint methodInjectionPoint, Argument argument);
        /**
         * Push an unresolved field onto the queue
         *
         * @param declaringType declaring type
         * @param fieldInjectionPoint The field injection point
         * @return This path
         */
        Path pushFieldResolve(ComponentDefinition declaringType, FieldInjectionPoint fieldInjectionPoint);
    }


    /**
     * A segment in a path
     */
    interface Segment {
        /**
         * @return The type requested
         */
        ComponentDefinition getDeclaringType();

        /**
         *
         * @return The name of the segment. For a field this is the field name, for a method the method name and for a constructor the type name
         */
        String getName();

        /**
         * @return The arguments to create the type. For a field this will be empty
         */
        Argument getArgument();
    }
}