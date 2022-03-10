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
public class ExecutionContextTasklet1 implements Tasklet {
    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("[Execution Context TEST] step1 was executed.");

        ExecutionContext jobContext = contribution.getStepExecution().getJobExecution().getExecutionContext();
        ExecutionContext stepContext = contribution.getStepExecution().getExecutionContext();

        String jobName = chunkContext.getStepContext()
                .getStepExecution()
                .getJobExecution()
                .getJobInstance()
                .getJobName();
        String stepName = chunkContext.getStepContext()
                .getStepExecution()
                .getStepName();

        if (jobContext.get("jobName") == null) {
            jobContext.put("jobName", jobName);
        }

        if (stepContext.get("stepName") == null) {
            stepContext.put("stepName", stepName);
        }

        log.info("jabName = {}, stepName = {}", jobContext.get("jobName"), jobContext.get("stepName"));

        return RepeatStatus.FINISHED;
    }
}
