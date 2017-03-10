package colin.schema.type;

import static graphql.Scalars.GraphQLLong;
import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;

import graphql.schema.GraphQLObjectType;
import org.springframework.stereotype.Component;

@Component
public class UserType {

    public GraphQLObjectType build() {
        return newObject()
                .name("User")
                .field(newFieldDefinition()
                        .name("id")
                        .type(GraphQLLong))

                .field(newFieldDefinition()
                        .name("firstName")
                        .type(GraphQLString))

                .field(newFieldDefinition()
                        .name("lastName")
                        .type(GraphQLString))

                .field(newFieldDefinition()
                        .name("userName")
                        .type(GraphQLString))

                .field(newFieldDefinition()
                        .name("title")
                        .type(GraphQLString))

                .field(newFieldDefinition()
                        .name("jobTitle")
                        .type(GraphQLString))

                .build();
    }
}
