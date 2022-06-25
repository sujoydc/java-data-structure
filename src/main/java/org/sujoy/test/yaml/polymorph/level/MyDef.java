package org.sujoy.test.yaml.polymorph.level;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyDef {

    private String name;
    private String age;
    private MyData data;

}
