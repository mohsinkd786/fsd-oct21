package com.mohsinkd786.mappers;

import com.mohsinkd786.dtos.UserDto;
import com.mohsinkd786.repositories.entities.User;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends ConfigurableMapper {

    @Override
    protected void configure(MapperFactory factory) {
        //super.configure(factory);
        factory
                .registerClassMap(factory.classMap(User.class, UserDto.class)
        .byDefault()
                        .toClassMap());
    }
}
