package com.example.demo.test.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.junit.Test;

public class ProcessDefinitionTest {
    /**流程引擎（核心对象），默认加载类路径下命名为activiti.cfg.xml*/
    // 引擎配置
    ProcessEngineConfiguration pec=ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("bpmn/activiti.cfg.xml");
    // 获取流程引擎对象
    ProcessEngine processEngine=pec.buildProcessEngine();

    //部署流程定义
    @Test
    public void deployementProcessDefinition(){
        Deployment deployment = processEngine.getRepositoryService()//获取流程定义和部署对象相关的Service
                .createDeployment()//创建部署对象
                .name("helloworld演示")//声明流程的名称
                .addClasspathResource("bpmn/Process-1.bpmn")//加载资源文件，一次只能加载一个文件
                .addClasspathResource("bpmn/Process-1.png")//
                .deploy();//完成部署
        System.out.println("部署ID："+deployment.getId());//1
        System.out.println("部署时间："+deployment.getDeploymentTime());
    }

}
