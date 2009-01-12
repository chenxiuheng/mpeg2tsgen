/* @flavorc
 *
 * STT.java
 * 
 * This file was automatically generated by flavorc
 * from the source file:
 *     'STT.fl'
 *
 * For information on flavorc, visit the Flavor Web site at:
 *     http://flavor.sourceforge.net
 *
 * -- Do not edit by hand --
 *
 */

package STT;
import flavor.*;
import java.io.*;

public class STT {
    int table_id;
    int section_syntax_indicator;
    int private_indicator;
    int reserved1;
    int section_length;
    int table_id_extension;
    int reserved2;
    int version_number;
    int current_next_indicator;
    int section_number;
    int last_section_number;
    int protocol_version;
    int system_time;
    int GPS_UTC_offset;
    int daylight_savings;
    int remain_desc_bytes;
    Descriptor descriptor;
    int CRC_32;

    public int get(IBitstream _F_bs) throws IOException {
        int _F_ret = 0;
        MapResult _F_mr;
        table_id = _F_bs.getbits(8);
        if (table_id != 205) {
            Util.flerror("Const value mismatch for 'table_id'");
            _F_ret++;
        }
        section_syntax_indicator = _F_bs.getbits(1);
        if (section_syntax_indicator != 1) {
            Util.flerror("Const value mismatch for 'section_syntax_indicator'");
            _F_ret++;
        }
        private_indicator = _F_bs.getbits(1);
        if (private_indicator != 1) {
            Util.flerror("Const value mismatch for 'private_indicator'");
            _F_ret++;
        }
        reserved1 = _F_bs.getbits(2);
        if (reserved1 != 3) {
            Util.flerror("Const value mismatch for 'reserved1'");
            _F_ret++;
        }
        section_length = _F_bs.getbits(12);
        table_id_extension = _F_bs.getbits(16);
        if (table_id_extension != 0) {
            Util.flerror("Const value mismatch for 'table_id_extension'");
            _F_ret++;
        }
        reserved2 = _F_bs.getbits(2);
        if (reserved2 != 3) {
            Util.flerror("Const value mismatch for 'reserved2'");
            _F_ret++;
        }
        version_number = _F_bs.getbits(5);
        if (version_number != 0) {
            Util.flerror("Const value mismatch for 'version_number'");
            _F_ret++;
        }
        current_next_indicator = _F_bs.getbits(1);
        if (current_next_indicator != 1) {
            Util.flerror("Const value mismatch for 'current_next_indicator'");
            _F_ret++;
        }
        section_number = _F_bs.getbits(8);
        if (section_number != 0) {
            Util.flerror("Const value mismatch for 'section_number'");
            _F_ret++;
        }
        last_section_number = _F_bs.getbits(8);
        if (last_section_number != 0) {
            Util.flerror("Const value mismatch for 'last_section_number'");
            _F_ret++;
        }
        protocol_version = _F_bs.getbits(8);
        system_time = _F_bs.getbits(32);
        GPS_UTC_offset = _F_bs.getbits(8);
        daylight_savings = _F_bs.getbits(16);
        remain_desc_bytes = section_length-17;
        while (remain_desc_bytes>0) {
            descriptor = new Descriptor();
            _F_ret += descriptor.get(_F_bs);
            remain_desc_bytes-=descriptor._F_lengthof;
            if (1==0) break;
        }
        CRC_32 = _F_bs.getbits(32);
        return _F_ret;
    }

    public int put(IBitstream _F_bs) throws IOException {
        int _F_ret = 0;
        MapResult _F_mr;
        int _F_parse = 0;
        _F_parse = 8;
        table_id = 205;
        _F_bs.putbits(table_id, _F_parse);
        _F_parse = 1;
        section_syntax_indicator = 1;
        _F_bs.putbits(section_syntax_indicator, _F_parse);
        _F_parse = 1;
        private_indicator = 1;
        _F_bs.putbits(private_indicator, _F_parse);
        _F_parse = 2;
        reserved1 = 3;
        _F_bs.putbits(reserved1, _F_parse);
        _F_bs.putbits(section_length, 12);
        _F_parse = 16;
        table_id_extension = 0;
        _F_bs.putbits(table_id_extension, _F_parse);
        _F_parse = 2;
        reserved2 = 3;
        _F_bs.putbits(reserved2, _F_parse);
        _F_parse = 5;
        version_number = 0;
        _F_bs.putbits(version_number, _F_parse);
        _F_parse = 1;
        current_next_indicator = 1;
        _F_bs.putbits(current_next_indicator, _F_parse);
        _F_parse = 8;
        section_number = 0;
        _F_bs.putbits(section_number, _F_parse);
        _F_parse = 8;
        last_section_number = 0;
        _F_bs.putbits(last_section_number, _F_parse);
        _F_bs.putbits(protocol_version, 8);
        _F_bs.putbits(system_time, 32);
        _F_bs.putbits(GPS_UTC_offset, 8);
        _F_bs.putbits(daylight_savings, 16);
        remain_desc_bytes = section_length-17;
        while (remain_desc_bytes>0) {
            _F_ret += descriptor.put(_F_bs);
            remain_desc_bytes-=descriptor._F_lengthof;
            if (1==0) break;
        }
        _F_bs.putbits(CRC_32, 32);
        return _F_ret;
    }

    public int putxml(IBitstream _F_bs, boolean bAttr) throws IOException {
        int _F_ret = 0;
        MapResult _F_mr;
        int _F_parse = 0;
        _F_parse = 8;
        table_id = _F_bs.getbits(_F_parse);
        if (table_id != 205) {
            Util.flerror("Const value mismatch for 'table_id'");
            _F_ret++;
            if (bAttr) {
                XML.WriteXmlElement("<table_id type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + table_id + "</table_id>");
            }
            else {
                XML.WriteXmlElement("<table_id bitLen=\"" + _F_parse + "\">" + table_id + "</table_id>");
            }
        }
        else {
            if (bAttr) {
                XML.WriteXmlElement("<table_id type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + table_id + "</table_id>");
            }
            else {
                XML.WriteXmlElement("<table_id bitLen=\"" + _F_parse + "\">" + table_id + "</table_id>");
            }
        }
        _F_parse = 1;
        section_syntax_indicator = _F_bs.getbits(_F_parse);
        if (section_syntax_indicator != 1) {
            Util.flerror("Const value mismatch for 'section_syntax_indicator'");
            _F_ret++;
            if (bAttr) {
                XML.WriteXmlElement("<section_syntax_indicator type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + section_syntax_indicator + "</section_syntax_indicator>");
            }
            else {
                XML.WriteXmlElement("<section_syntax_indicator bitLen=\"" + _F_parse + "\">" + section_syntax_indicator + "</section_syntax_indicator>");
            }
        }
        else {
            if (bAttr) {
                XML.WriteXmlElement("<section_syntax_indicator type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + section_syntax_indicator + "</section_syntax_indicator>");
            }
            else {
                XML.WriteXmlElement("<section_syntax_indicator bitLen=\"" + _F_parse + "\">" + section_syntax_indicator + "</section_syntax_indicator>");
            }
        }
        _F_parse = 1;
        private_indicator = _F_bs.getbits(_F_parse);
        if (private_indicator != 1) {
            Util.flerror("Const value mismatch for 'private_indicator'");
            _F_ret++;
            if (bAttr) {
                XML.WriteXmlElement("<private_indicator type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + private_indicator + "</private_indicator>");
            }
            else {
                XML.WriteXmlElement("<private_indicator bitLen=\"" + _F_parse + "\">" + private_indicator + "</private_indicator>");
            }
        }
        else {
            if (bAttr) {
                XML.WriteXmlElement("<private_indicator type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + private_indicator + "</private_indicator>");
            }
            else {
                XML.WriteXmlElement("<private_indicator bitLen=\"" + _F_parse + "\">" + private_indicator + "</private_indicator>");
            }
        }
        _F_parse = 2;
        reserved1 = _F_bs.getbits(_F_parse);
        if (reserved1 != 3) {
            Util.flerror("Const value mismatch for 'reserved1'");
            _F_ret++;
            if (bAttr) {
                XML.WriteXmlElement("<reserved1 type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + reserved1 + "</reserved1>");
            }
            else {
                XML.WriteXmlElement("<reserved1 bitLen=\"" + _F_parse + "\">" + reserved1 + "</reserved1>");
            }
        }
        else {
            if (bAttr) {
                XML.WriteXmlElement("<reserved1 type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + reserved1 + "</reserved1>");
            }
            else {
                XML.WriteXmlElement("<reserved1 bitLen=\"" + _F_parse + "\">" + reserved1 + "</reserved1>");
            }
        }
        _F_parse = 12;
        section_length = _F_bs.getbits(_F_parse);
        if (bAttr) {
            XML.WriteXmlElement("<section_length type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + section_length + "</section_length>");
        }
        else {
            XML.WriteXmlElement("<section_length bitLen=\"" + _F_parse + "\">" + section_length + "</section_length>");
        }
        _F_parse = 16;
        table_id_extension = _F_bs.getbits(_F_parse);
        if (table_id_extension != 0) {
            Util.flerror("Const value mismatch for 'table_id_extension'");
            _F_ret++;
            if (bAttr) {
                XML.WriteXmlElement("<table_id_extension type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + table_id_extension + "</table_id_extension>");
            }
            else {
                XML.WriteXmlElement("<table_id_extension bitLen=\"" + _F_parse + "\">" + table_id_extension + "</table_id_extension>");
            }
        }
        else {
            if (bAttr) {
                XML.WriteXmlElement("<table_id_extension type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + table_id_extension + "</table_id_extension>");
            }
            else {
                XML.WriteXmlElement("<table_id_extension bitLen=\"" + _F_parse + "\">" + table_id_extension + "</table_id_extension>");
            }
        }
        _F_parse = 2;
        reserved2 = _F_bs.getbits(_F_parse);
        if (reserved2 != 3) {
            Util.flerror("Const value mismatch for 'reserved2'");
            _F_ret++;
            if (bAttr) {
                XML.WriteXmlElement("<reserved2 type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + reserved2 + "</reserved2>");
            }
            else {
                XML.WriteXmlElement("<reserved2 bitLen=\"" + _F_parse + "\">" + reserved2 + "</reserved2>");
            }
        }
        else {
            if (bAttr) {
                XML.WriteXmlElement("<reserved2 type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + reserved2 + "</reserved2>");
            }
            else {
                XML.WriteXmlElement("<reserved2 bitLen=\"" + _F_parse + "\">" + reserved2 + "</reserved2>");
            }
        }
        _F_parse = 5;
        version_number = _F_bs.getbits(_F_parse);
        if (version_number != 0) {
            Util.flerror("Const value mismatch for 'version_number'");
            _F_ret++;
            if (bAttr) {
                XML.WriteXmlElement("<version_number type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + version_number + "</version_number>");
            }
            else {
                XML.WriteXmlElement("<version_number bitLen=\"" + _F_parse + "\">" + version_number + "</version_number>");
            }
        }
        else {
            if (bAttr) {
                XML.WriteXmlElement("<version_number type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + version_number + "</version_number>");
            }
            else {
                XML.WriteXmlElement("<version_number bitLen=\"" + _F_parse + "\">" + version_number + "</version_number>");
            }
        }
        _F_parse = 1;
        current_next_indicator = _F_bs.getbits(_F_parse);
        if (current_next_indicator != 1) {
            Util.flerror("Const value mismatch for 'current_next_indicator'");
            _F_ret++;
            if (bAttr) {
                XML.WriteXmlElement("<current_next_indicator type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + current_next_indicator + "</current_next_indicator>");
            }
            else {
                XML.WriteXmlElement("<current_next_indicator bitLen=\"" + _F_parse + "\">" + current_next_indicator + "</current_next_indicator>");
            }
        }
        else {
            if (bAttr) {
                XML.WriteXmlElement("<current_next_indicator type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + current_next_indicator + "</current_next_indicator>");
            }
            else {
                XML.WriteXmlElement("<current_next_indicator bitLen=\"" + _F_parse + "\">" + current_next_indicator + "</current_next_indicator>");
            }
        }
        _F_parse = 8;
        section_number = _F_bs.getbits(_F_parse);
        if (section_number != 0) {
            Util.flerror("Const value mismatch for 'section_number'");
            _F_ret++;
            if (bAttr) {
                XML.WriteXmlElement("<section_number type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + section_number + "</section_number>");
            }
            else {
                XML.WriteXmlElement("<section_number bitLen=\"" + _F_parse + "\">" + section_number + "</section_number>");
            }
        }
        else {
            if (bAttr) {
                XML.WriteXmlElement("<section_number type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + section_number + "</section_number>");
            }
            else {
                XML.WriteXmlElement("<section_number bitLen=\"" + _F_parse + "\">" + section_number + "</section_number>");
            }
        }
        _F_parse = 8;
        last_section_number = _F_bs.getbits(_F_parse);
        if (last_section_number != 0) {
            Util.flerror("Const value mismatch for 'last_section_number'");
            _F_ret++;
            if (bAttr) {
                XML.WriteXmlElement("<last_section_number type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + last_section_number + "</last_section_number>");
            }
            else {
                XML.WriteXmlElement("<last_section_number bitLen=\"" + _F_parse + "\">" + last_section_number + "</last_section_number>");
            }
        }
        else {
            if (bAttr) {
                XML.WriteXmlElement("<last_section_number type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + last_section_number + "</last_section_number>");
            }
            else {
                XML.WriteXmlElement("<last_section_number bitLen=\"" + _F_parse + "\">" + last_section_number + "</last_section_number>");
            }
        }
        _F_parse = 8;
        protocol_version = _F_bs.getbits(_F_parse);
        if (bAttr) {
            XML.WriteXmlElement("<protocol_version type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + protocol_version + "</protocol_version>");
        }
        else {
            XML.WriteXmlElement("<protocol_version bitLen=\"" + _F_parse + "\">" + protocol_version + "</protocol_version>");
        }
        _F_parse = 32;
        system_time = _F_bs.getbits(_F_parse);
        if (bAttr) {
            XML.WriteXmlElement("<system_time type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + system_time + "</system_time>");
        }
        else {
            XML.WriteXmlElement("<system_time bitLen=\"" + _F_parse + "\">" + system_time + "</system_time>");
        }
        _F_parse = 8;
        GPS_UTC_offset = _F_bs.getbits(_F_parse);
        if (bAttr) {
            XML.WriteXmlElement("<GPS_UTC_offset type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + GPS_UTC_offset + "</GPS_UTC_offset>");
        }
        else {
            XML.WriteXmlElement("<GPS_UTC_offset bitLen=\"" + _F_parse + "\">" + GPS_UTC_offset + "</GPS_UTC_offset>");
        }
        _F_parse = 16;
        daylight_savings = _F_bs.getbits(_F_parse);
        if (bAttr) {
            XML.WriteXmlElement("<daylight_savings type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + daylight_savings + "</daylight_savings>");
        }
        else {
            XML.WriteXmlElement("<daylight_savings bitLen=\"" + _F_parse + "\">" + daylight_savings + "</daylight_savings>");
        }
        remain_desc_bytes = section_length-17;
        while (remain_desc_bytes>0) {
            descriptor = new Descriptor();
            XML.IntoAClass("descriptor", 0);
            _F_ret += descriptor.putxml(_F_bs, bAttr);
            XML.OutOfClass("</descriptor>");
            remain_desc_bytes-=descriptor._F_lengthof;
            if (1==0) break;
        }
        _F_parse = 32;
        CRC_32 = _F_bs.getbits(_F_parse);
        if (bAttr) {
            XML.WriteXmlElement("<CRC_32 type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + CRC_32 + "</CRC_32>");
        }
        else {
            XML.WriteXmlElement("<CRC_32 bitLen=\"" + _F_parse + "\">" + CRC_32 + "</CRC_32>");
        }
        return _F_ret;
    }
}
