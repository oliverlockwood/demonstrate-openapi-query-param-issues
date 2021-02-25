package com.oliverlockwood.example.client.configuration;

import feign.RequestTemplate;
import feign.codec.Encoder;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
public class AbstractRequestEncoder<T> implements Encoder {

    @Override
    @SuppressWarnings("unchecked")
    public void encode(Object object, Type type, RequestTemplate template) {

        T request = (T) object;

        Map<String, Collection<String>> queries = new HashMap<>();

        for (Field field : getAllFields(request.getClass())) {
            field.setAccessible(true);

            Object value;
            try {
                value = field.get(request);
            }
            catch (IllegalAccessException e) {
                log.warn("Unable to access field value", e);
                continue;
            }

            if (value != null) {

                Collection<String> list = new ArrayList<>();
                // isInstance works on generics as well!
                // this flattens out the value map into queries
                if (queries.getClass().isInstance(value)) {
                    queries.putAll(queries.getClass().cast(value));
                }
                else if (value instanceof Collection) {
                    for (Object elementValue : (Collection<Object>) value) {
                        list.add(elementValue.toString());
                    }
                }
                else if (value instanceof String[]) {
                    list.addAll(Arrays.asList((String[]) value));
                }
                else {
                    list.add(value.toString());
                }
                queries.put(field.getName(), list);

            }

        }

        queries.putAll(template.queries());
        template.queries(queries);
    }


    private List<Field> getAllFields(Class<?> type) {

        List<Field> fields = new ArrayList<>();
        return getAllFields(fields, type);
    }


    private List<Field> getAllFields(List<Field> fields, Class<?> type) {

        fields.addAll(Arrays.asList(type.getDeclaredFields()));

        if (type.getSuperclass() != null) {
            fields = getAllFields(fields, type.getSuperclass());
        }

        return fields;
    }

}
