package colin.schema.type;

import static graphql.Scalars.GraphQLLong;
import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;

import colin.repository.TaskRepository;
import colin.repository.UserRepository;
import graphql.schema.GraphQLList;
import graphql.schema.GraphQLObjectType;
import org.bonitasoft.engine.bpm.process.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CaseType {

    @Autowired
    private UserType userType;

    @Autowired
    private TaskType taskType;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;

    public GraphQLObjectType build() {
        return newObject()
                .name("Case")
                .field(newFieldDefinition()
                        .name("id")
                        .type(GraphQLLong))

                .field(newFieldDefinition()
                        .name("name")
                        .type(GraphQLString))

                .field(newFieldDefinition()
                        .name("startedBy")
                        .type(userType.build())
                        .dataFetcher(env -> {
                            ProcessInstance source = (ProcessInstance) env.getSource();
                            return userRepository.get(source.getStartedBy());
                        }))

                .field(newFieldDefinition()
                        .name("archivedTasks")
                        .type(new GraphQLList(taskType.build()))
                        .dataFetcher(env -> {
                            ProcessInstance source = (ProcessInstance) env.getSource();
                            return taskRepository.getAllArchived(source.getId());
                        })

                ).build();
    }
}
