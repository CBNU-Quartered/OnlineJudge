package util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ShellCommandUtilTest {
    @Test
    void run() throws Exception {
        String command = "echo \"hello\"";
        String[] callCommand = {"/bin/bash", "-c", command};
        System.out.println(ShellCommandUtil.execCommand(callCommand).get(1));
        assertThat(ShellCommandUtil.execCommand(callCommand).get(0)).isEqualTo("0");
    }
}