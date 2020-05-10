package util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetUtil {
    private static final Log log = LogFactory.getLog(NetUtil.class);

    /**
     * 简单的连接
     * @param urlStr
     * @param method
     * @param postParams json格式
     * @return
     */
    public static String createNetConnection(String urlStr, String method, String postParams){
        String result = "";
        HttpURLConnection connection;
        BufferedWriter writer;
        try {
            URL url = new URL(urlStr);
            connection = (HttpURLConnection)url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod(method);
            connection.setUseCaches(false);

            if("POST".equals(method)){
                connection.setRequestProperty("Content-Type", "application/json;charset=utf-8");
            }

            connection.connect();

            if("POST".equals(method)){
                connection.setRequestProperty("Content-Type", "application/json;charset=utf-8");
                writer = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream(), "UTF-8"));
                try {
                    writer.write(postParams);
                }finally {
                    writer.close();
                }
            }

            StringBuilder content = new StringBuilder();
            int response_code = connection.getResponseCode();
            if (response_code == HttpURLConnection.HTTP_OK) {
                InputStream in = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line);
                }
                result = content.toString();
            }
        } catch (Exception e) {
            log.error("Simple net connection error",e);
        }
        return result;
    }
}
