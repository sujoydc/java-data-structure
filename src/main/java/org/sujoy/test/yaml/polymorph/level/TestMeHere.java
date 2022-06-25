package org.sujoy.test.yaml.polymorph.level;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestMeHere extends MyData {

    private Map<String, String> common;
    private Map<String, String> here;
    private String              arg;

    @Override
    public String myType(){
        return "HERE";
    }
}
