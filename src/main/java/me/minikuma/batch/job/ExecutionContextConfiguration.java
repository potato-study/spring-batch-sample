package me.minikuma.batch.job;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.minikuma.batch.tasklet.ExecutionContextTasklet1;
import me.minikuma.batch.tasklet.ExecutionContextTasklet2;
import me.minikuma.batch.tasklet.ExecutionContextTasklet3;
import me.minikuma.batch.tasklet.ExecutionContextTasklet4;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Execution Context Configuration (객체 공유) 점검
 * Step 간 공유 객체 다루기
 */

@Slf4j
@Configuration
@RequiredArgsConstructor
public class ExecutionContextConfiguration {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    private final ExecutionContextTasklet1 executionContextTasklet1;
    private final ExecutionContextTasklet2 executionContextTasklet2;
    private final ExecutionContextTasklet3 executionContextTasklet3;
    private final ExecutionContextTasklet4 executionContextTasklet4;

    @Bean
    public Job executionContextJob() {
        return jobBuilderFactory.get("executionContextJob")
                .start(stepExecutionContext1())
                .next(stepExecutionContext2())
                .next(stepExecutionContext3())
                .next(stepExecutionContext4())
                .build();
    }

    @Bean
    public Step stepExecutionContext1() {
        return stepBuilderFactory.get("step1")
                .tasklet(executionContextTasklet1)
                .build();
    }

    @Bean
    public Step stepExecutionContext2() {
        return stepBuilderFactory.get("step2")
                .tasklet(executionContextTasklet2)
                .build();
    }

    @Bean
    public Step stepExecutionContext3() {
        return stepBuilderFactory.get("step3")
                .tasklet(executionContextTasklet3)
                .build();
    }

    @Bean
    public Step stepExecutionContext4() {
        return stepBuilderFactory.get("step4")
                .tasklet(executionContextTasklet4)
                .build();
    }
}
