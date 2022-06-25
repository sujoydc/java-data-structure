package org.sujoy.test.yaml.polymorph;


import java.io.FileInputStream;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.nodes.Tag;

@Slf4j
public class MyYMLInterfaceTest {

    @SneakyThrows
    public static void main(String[] args) {
        log.info("Starting YAML Testing...");
        Constructor constructor = new Constructor(MyDef.class);

        TypeDescription myDefTypeDesc = new TypeDescription(MyDef.class);
        myDefTypeDesc.addPropertyParameters("testMe", TestMeDef.class);

        TypeDescription testMeTypeDesc = new TypeDescription(TestMeDef.class);
        testMeTypeDesc.addPropertyParameters("data", MyData.class);

        constructor.addTypeDescription(myDefTypeDesc);
        constructor.addTypeDescription(testMeTypeDesc);
        constructor.addTypeDescription(new TypeDescription(TestMeHere.class, new Tag("!here")));
        constructor.addTypeDescription(new TypeDescription(TestMeThere.class, new Tag("!there")));

        Yaml  myYaml = new Yaml(constructor);
        MyDef myDef  = myYaml.load(new FileInputStream("src/main/resources/TestThere.yml"));

        log.info("YAML File:{}", myDef.getAge());

    }
}
