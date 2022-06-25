package org.sujoy.test.yaml.polymorph.level;


import java.io.FileInputStream;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.nodes.Tag;

@Slf4j
public class MyYMLLevelTest {

    @SneakyThrows
    public static void main(String[] args) {
        log.info("Starting YAML Level Testing...");
        Constructor constructor = new Constructor(MyDef.class);

        TypeDescription myDefTypeDesc = new TypeDescription(MyDef.class);
        myDefTypeDesc.addPropertyParameters("data", MyData.class);

        constructor.addTypeDescription(myDefTypeDesc);
        constructor.addTypeDescription(new TypeDescription(TestMeHere.class, new Tag("!here")));
        constructor.addTypeDescription(new TypeDescription(TestMeThere.class, new Tag("!there")));

        Yaml  myYaml = new Yaml(constructor);
        MyDef myDef  = myYaml.load(new FileInputStream("src/main/resources/TestLevel1.yml"));

        log.info("YAML File:{}", myDef.getData().myType());

    }
}
