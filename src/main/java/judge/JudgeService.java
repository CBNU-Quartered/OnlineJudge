package judge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import util.ShellCommandUtil;

import java.io.*;
import java.util.Arrays;

@Service
public class JudgeService {
    private static final Logger logger = LoggerFactory.getLogger(JudgeService.class);

    private static final String TESTER_DIR = "/Users/hyogeon/Downloads/JudgerProject/Desktop/tester";
    private static final String DOCKER_DIR = "/home";

    private static final String RUN_CODE_COMMAND = "./libjudger.so " +
            "--max_cpu_time=1000 " +
            "--max_real_time=2000 " +
            "--max_memory=536870912 " +
            "--max_process_number=200 " +
            "--max_output_size=16384 " +
            "--exe_path=\"/home/Desktop/tester/test\" " +
            "--input_path=\"/home/Desktop/tester/input.txt\" " +
            "--output_path=\"/home/Desktop/tester/output.txt\" " +
            "--error_path=\"/home/Desktop/tester/error.txt\" " +
            "--uid=0 --gid=0 " +
            "--seccomp_rule_name=\"c_cpp\"";

    private static final String C_COMPILE_COMMAND = "gcc " + TESTER_DIR + "/test.c -o" + TESTER_DIR + "/test";


    public void run(String source, String language) throws IOException {
        String fileName = "test.c";
        logger.info(String.valueOf(new File(TESTER_DIR).exists()));
        FileWriter fileWriter = new FileWriter(TESTER_DIR + "/" + fileName);
        fileWriter.write(source);
        fileWriter.close();
        logger.info(C_COMPILE_COMMAND);
        logger.info(Runtime.getRuntime().exec(C_COMPILE_COMMAND).getOutputStream().toString());

//        String[] command = {"/bin/bash", "-c", C_COMPILE_COMMAND};
//        logger.info("compile: {}", ShellCommandUtil.execCommand(command));
//        logger.info("run: {}", ShellCommandUtil.execCommand(RUN_CODE_COMMAND));
    }
}