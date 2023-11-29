<?php
header('Access-Control-Allow-Origin: *');
header('Content-Type: text/plain');

    $scriptPath = "cgi-bin/start-spring-boot.sh";

    // Execute the shell script
    $output = shell_exec("bash $scriptPath");

    // Output the result
    echo $output;
?>
