""" XML to JSON """

import sys
import json
import xmltodict

def main(xml_in):
    """This is a Main Function"""
    print(xml_in)
    with open(xml_in, 'r') as reader:
        xml_data = reader.read()

    xml_data = xmltodict.parse(xml_data, attr_prefix="")
    json_data = json.dumps(xml_data, indent=4)

    with open(xml_in.replace(".xml", ".json"), 'w') as writer:
        writer.write(json_data)

    print(json_data)
main(sys.argv[1])
