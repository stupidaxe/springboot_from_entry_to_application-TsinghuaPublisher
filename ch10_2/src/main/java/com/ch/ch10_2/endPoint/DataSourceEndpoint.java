package com.ch.ch10_2.endPoint;
import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;
import com.zaxxer.hikari.HikariConfigMXBean;
import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.HikariPoolMXBean;
//注册为端点，id不能使用驼峰法（dataSource），需要以-分割
@Endpoint(id = "data-source")
@Component
public class DataSourceEndpoint {
	//HikariDataSource提供多个监控信息
	HikariDataSource ds;
    public DataSourceEndpoint(HikariDataSource ds) {
    	this.ds = ds;
    }
    @ReadOperation
    public Map<String, Object> info() {
    	Map<String, Object> map = new HashMap<String, Object>();
    	//连接池配置
    	HikariConfigMXBean configBean = ds.getHikariConfigMXBean();
    	map.put("max", configBean.getMaximumPoolSize());
    	//连接池运行状态
    	HikariPoolMXBean mxBean = ds.getHikariPoolMXBean();
    	map.put("active", mxBean.getActiveConnections());
    	map.put("idle", mxBean.getIdleConnections());
    	//连接池无连接时，等待获取连接的线程个数
    	map.put("wait", mxBean.getThreadsAwaitingConnection());
        return map;
    }
    @WriteOperation
    public void setMax(int max) {
    	ds.getHikariConfigMXBean().setMaximumPoolSize(max);
    }
}
