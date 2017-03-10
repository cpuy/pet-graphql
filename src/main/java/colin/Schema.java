package colin;

import static graphql.Scalars.GraphQLID;
import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;
import static graphql.schema.GraphQLSchema.newSchema;

import java.util.UUID;

import colin.domain.Case;
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

    public static GraphQLObjectType bpmType = newObject()
            .name("bpm")
            .field(newFieldDefinition()
                    .name("case")
                    .type(caseType)
            .dataFetcher(env -> new Case(UUID.randomUUID().toString(), "a simple case")))
            .build();

    public static GraphQLSchema caseSchema = newSchema()
            .query(bpmType)
            .build();
}
