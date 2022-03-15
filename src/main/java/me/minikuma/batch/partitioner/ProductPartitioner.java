package me.minikuma.batch.partitioner;

import me.minikuma.batch.domain.ProductVO;
import me.minikuma.batch.job.api.QueryGenerator;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class ProductPartitioner implements Partitioner {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Map<String, ExecutionContext> partition(int gridSize) {

        ProductVO[] productList = QueryGenerator.getProductListByType(dataSource);
        Map<String, ExecutionContext> result = new HashMap<>();

        int num = 0;

        for (ProductVO productVO : productList) {
            ExecutionContext executionContext = new ExecutionContext();

            result.put("partition".concat(String.valueOf(num)), executionContext);
            executionContext.put("product", productVO);

            num++;
        }
        return result;
    }
}
