package colin;

import static graphql.schema.GraphQLSchema.newSchema;

import colin.schema.RootType;
import graphql.schema.GraphQLSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Schema {

    @Autowired
    private RootType rootType;

    public GraphQLSchema build() {
        return newSchema()
                .query(rootType.build())
                .build();
    }
}
