package me.minikuma.batch.tasklet;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ExecutionContextTasklet4 implements Tasklet {
    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("[Execution Context TEST] step4 was executed.");

        Object name = chunkContext.getStepContext().getStepExecution().getExecutionContext().get("name");
        log.info("name = {}", name);

        return RepeatStatus.FINISHED;
    }
}
