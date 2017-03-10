package colin.schema.type;


import static graphql.Scalars.GraphQLLong;
import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;

import graphql.schema.GraphQLObjectType;
import org.springframework.stereotype.Component;

@Component
public class TaskType {

    public GraphQLObjectType build() {
        return newObject()
                .name("Task")
                .field(newFieldDefinition()
                        .name("id")
                        .type(GraphQLLong))
                .field(newFieldDefinition()
                        .name("name")
                        .type(GraphQLString))
                .build();
    }
}
