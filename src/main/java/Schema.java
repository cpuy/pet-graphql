import static graphql.Scalars.GraphQLID;
import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;
import static graphql.schema.GraphQLSchema.newSchema;

import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;

public class Schema {

    public static GraphQLObjectType caseType = newObject()
            .name("Case")
            .field(newFieldDefinition()
                    .name("id")
                    .type(GraphQLID))
            .field(newFieldDefinition()
                    .name("name")
                    .type(GraphQLString))
            .build();

    public static GraphQLObjectType userType = newObject()
            .name("User")
            .field(newFieldDefinition()
                    .name("id")
                    .type(GraphQLID))
            .field(newFieldDefinition()
                    .name("username")
                    .type(GraphQLString))
            .build();

    public static GraphQLSchema caseSchema = newSchema()
            .query(caseType)
            .build();
}
