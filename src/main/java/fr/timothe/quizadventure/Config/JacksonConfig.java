package fr.timothe.quizadventure.Config;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.bson.types.ObjectId;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {

    @Bean
    public Module objectIdModule() {
        SimpleModule module = new SimpleModule();
        module.addSerializer(ObjectId.class, new ToStringSerializer());
        return module;
    }
}
