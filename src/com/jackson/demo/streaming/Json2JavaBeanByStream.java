package com.jackson.demo.streaming;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/*Jackson API提供了token对每个Json对象，例如，Json开始符号“{”是token指向的第一个解析的对象， 
 key:value键值对是另一个单独的对象。这个API很强大，但也需要编写大量代码。
 不推荐使用，平时更多的是使用DataBinding和TreeModel来处理json 
 */
public class Json2JavaBeanByStream {
    public static void main(String[] args) throws JsonParseException, IOException {
        JsonFactory facotry = new JsonFactory();
        JsonParser parser = facotry.createParser(new File("country3.json"));
        while (!parser.isClosed()) {
            JsonToken token = parser.nextToken();
            if (token == null) {
                break;
            }
            if (JsonToken.FIELD_NAME.equals(token) && "population".equals(parser.getCurrentName())) {
                token = parser.nextToken();
                if (!JsonToken.START_ARRAY.equals(token)) {
                    break;
                }
                token = parser.nextToken();
                if (!JsonToken.START_OBJECT.equals(token)) {
                    break;
                }
                while (true) {
                    token = parser.nextToken();
                    if (token == null) {
                        break;
                    }
                    if (JsonToken.FIELD_NAME.equals(token) && "population".equals(parser.getCurrentName())) {
                        token = parser.nextToken();
                        System.out.println(parser.getCurrentName() + " : " + parser.getIntValue());
                    }
                }
            }
        }

    }
}
