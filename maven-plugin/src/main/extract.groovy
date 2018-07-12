import org.json.JSONObject
import org.json.XML

File outputDir = new File(project.build.outputDirectory)
File pluginXml = new File(outputDir, 'META-INF/maven/plugin.xml')

def xml = pluginXml.text

JSONObject parsed = XML.toJSONObject(xml)
def json = parsed.toString(2)

File targetDir = new File(project.build.directory)
File pluginJson = new File(targetDir, 'plugin.json')
pluginJson.text = json
