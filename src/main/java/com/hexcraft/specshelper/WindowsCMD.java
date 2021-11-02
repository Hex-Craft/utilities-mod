package com.hexcraft.specshelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WindowsCMD
{
    public String getInfo(String command) throws IOException
    {
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec(command);
        BufferedReader systemInformationReader = new BufferedReader(new InputStreamReader(process.getInputStream(), "CP866"));

        StringBuilder stringBuilder = new StringBuilder();
        String line;

        while ((line = systemInformationReader.readLine()) != null)
        {
            stringBuilder.append(line);
            stringBuilder.append(System.lineSeparator());
        }

        return stringBuilder.toString().trim();
    }
}