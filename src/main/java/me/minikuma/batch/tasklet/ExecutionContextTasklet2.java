package me.minikuma.batch.tasklet;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ExecutionContextTasklet2 implements Tasklet {
    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("[Execution Context TEST] step2 was executed.");

        ExecutionContext jobContext = chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext();
        ExecutionContext stepContext = chunkContext.getStepContext().getStepExecution().getExecutionContext();

        log.info("jobName = {}, stepName = {}", jobContext.get("jobName"), stepContext.get("stepName"));

        String stepName = chunkContext.getStepContext().getStepExecution().getStepName();

        if (stepContext.get("stepName") == null) {
            stepContext.put("stepName", stepName);
        }

        return RepeatStatus.FINISHED;
    }
}
