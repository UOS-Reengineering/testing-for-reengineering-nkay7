package example.project.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * A class defining the definition of a driving scenario, which is dependent on the domain/application.
 * This must be modified and updated with class Snapshot.
 */
public class Scenario {
    String roadType;
    String weatherCondition;
    List<Float> initEgoCarPos;  // (x, y)
    List<Float> initCarInFrontPos;  // (x, y)

    public Scenario() {
        roadType = null;
        weatherCondition = null;
        initEgoCarPos = null;
        initCarInFrontPos = null;
    }

    public Scenario(String scenarioDescription) {
        // parse scenarioDescription and save the result to the class attributes
        // not implemented
    }

   public boolean equals(Object obj){
        if(obj == null){
            return false;
        }

        Scenario scenario = (Scenario) obj;
        double disEgo = Math.sqrt(Math.pow(initEgoCarPos.get(0)-scenario.initEgoCarPos.get(0),2)+Math.pow(initEgoCarPos.get(1)-scenario.initEgoCarPos.get(1),2));
        double disIn = Math.sqrt(Math.pow(initCarInFrontPos.get(0)-scenario.initCarInFrontPos.get(0),2)+Math.pow(initCarInFrontPos.get(1)-scenario.initCarInFrontPos.get(1),2));
       return roadType.equals(scenario.roadType)
               && weatherCondition.equals(scenario.weatherCondition)
               && (disEgo<0.05)
               && (disIn<0.05);

   }
}
