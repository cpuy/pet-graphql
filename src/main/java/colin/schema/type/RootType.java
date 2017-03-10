package colin.schema.type;

import static graphql.Scalars.GraphQLLong;
import static graphql.schema.GraphQLArgument.newArgument;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;

import colin.repository.CaseRepository;
import graphql.schema.GraphQLObjectType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RootType {

    @Autowired
    private CaseType caseType;

    @Autowired
    private CaseRepository caseRepository;

    public GraphQLObjectType build() {
        return newObject()
                .name("bpm")
                .field(newFieldDefinition()
                        .name("case")
                        .type(caseType.build())
                        .argument(newArgument()
                                .name("id")
                                .type(GraphQLLong))

                        .dataFetcher(env -> {
                            Long id = env.getArgument("id");
                            return caseRepository.get(id);
                        }))
                .build();
    }
}
