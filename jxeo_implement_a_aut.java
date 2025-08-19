import java.util.*;

public class JXEO_Implement_A_AUT {

    // Script Parser Class
    public static class ScriptParser {
        private Map<String, String> scriptMap = new HashMap<>();
        private List<String> scriptLines = new ArrayList<>();

        public void parseScript(String script) {
            String[] lines = script.split("\n");
            for (String line : lines) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    scriptMap.put(parts[0].trim(), parts[1].trim());
                }
            }
        }

        public String getCommand(String key) {
            return scriptMap.get(key);
        }

        public void executeScript() {
            for (String line : scriptLines) {
                String command = getCommand(line);
                if (command != null) {
                    System.out.println("Executing command: " + command);
                    // Add code to execute the command
                } else {
                    System.out.println("Unknown command: " + line);
                }
            }
        }

        public void addScriptLine(String line) {
            scriptLines.add(line);
        }
    }

    public static void main(String[] args) {
        ScriptParser parser = new ScriptParser();
        parser.parseScript("open:open_file\nsave:save_file\nexit:exit_app");
        parser.addScriptLine("open");
        parser.addScriptLine("save");
        parser.addScriptLine("exit");
        parser.executeScript();
    }
}