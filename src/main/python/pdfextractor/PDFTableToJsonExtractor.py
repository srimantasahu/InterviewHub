"""
setup notes
-----------
pip install pdfplumber
or
pip3 install pdfplumber
or
python3 -m venv path/to/venv
source path/to/venv/bin/activate
python3 -m pip install pdfplumber

test script
-----------
python3 -c "import pdfplumber; print('pdfplumber is installed successfully')"

"""

import pdfplumber
import json

all_rows = []

with pdfplumber.open("/Users/srimantasahu/Downloads/HPE_dp00003542en_us_Gen11.pdf") as pdf:
    headers = ['Product Category', 'Description', 'Build#', 'Version', 'Upgrade Requirement', 'Filename', 'Release Status']
    for page_num, page in enumerate(pdf.pages, start=1):
        tables = page.extract_tables()

        for table_num, table in enumerate(tables, start=1):
            if not table:
                continue

            for row in table[1:]:
                if row[0] is None or str(row[0]).strip() == "":
                    continue  # Skip blank/empty rows

                row_dict = {}
                j = 0  # index for headers

                for i in range(len(row)):
                    value = row[i]
                    if value is not None and str(value).strip() != '':
                        clean_value = str(value).replace('\n', ' ').strip()
                        if j < len(headers):
                            row_dict[headers[j]] = clean_value
                        j += 1

                all_rows.append(row_dict)

# Convert to JSON
json_output = json.dumps(all_rows, indent=2, ensure_ascii=False)

# Save to a file (optional)
with open("output.json", "w", encoding="utf-8") as f:
    f.write(json_output)

# Print JSON
print(json_output)


"""
--------------------------------------------------- table ---------------------------------------------------
['', None, None, '', '', None, None, '', '', None, None, '', '', None, None]
['', 'Product', '', 'Description', '', 'Build', '', 'Version', '', 'Upgrade', '', 'Filename', '', 'Release', '']
[None, 'Category', None, None, None, '#', None, None, None, 'Requirement', None, None, None, 'Status', None]
['', None, None, '', '', None, None, '', '', None, None, '', '', None, None]
['Application\n- System\nManagement', None, None, 'Integrated Smart\nUpdate Tools 4.5.0\nfor ESXi 7.0', '14', None, None, '2023.09.00', 'Recommended', None, None, 'cp057456.zip', 'new', None, None]
['Application\n- System\nManagement', None, None, 'Integrated Smart\nUpdate Tools for\nWindows x64', '7', None, None, '4.5.0.0', 'Recommended', None, None, 'cp057442.exe', 'update', None, None]
['Application\n- System\nManagement', None, None, 'Integrated Smart\nUpdate Tools 4.5.0\nfor ESXi 8.0', '27', None, None, '2023.09.00', 'Recommended', None, None, 'cp057459.zip', 'new', None, None]
['Application\n- System\nManagement', None, None, 'Integrated Smart\nUpdate Tools for\nLinux x64', '20', None, None, '4.5.0.0', 'Recommended', None, None, 'sut-4.5.0-\n20.linux.x86_64.\nrpm', 'update', None, None]
['BIOS -\nSystem\nROM', None, None, 'ROM Flash\nFirmware Package\n- HPE ProLiant\nDL20\nGen11/ML30\nGen11 (U65)\nServers', '19', None, None, '1.40_10-\n18-2023', 'Recommended', None, None, 'U65_1.40_10_1\n8_2023.fwpkg', 'new', None, None]
['BIOS -\nSystem\nROM', None, None, 'ROM Flash\nFirmware Package\n- HPE ProLiant\nDL110 Gen11\n(U62) Servers', '1', None, None, '1.46_09-\n26-2023', 'Recommended', None, None, 'U62_1.46_09_2\n6_2023.fwpkg', 'new', None, None]
['BIOS -\nSystem\nROM', None, None, 'ROM Flash\nFirmware Package\n- HPE ProLiant\nDL320/ML110\nGen11 (U63)\nServers', '2', None, None, '1.46_09-\n26-2023', 'Recommended', None, None, 'U63_1.46_09_2\n6_2023.fwpkg', 'new', None, None]
--------------------------------------------------- table ---------------------------------------------------
['BIOS -\nSystem\nROM', 'ROM Flash\nFirmware Package\n- HPE Alletra\n4110/Alletra\n4120/ProLiant\nDL380a Gen11\n(U58) Servers', '1', '1.46_09-\n26-2023', 'Recommended', 'U58_1.46_09_2\n6_2023.fwpkg', 'new']
['BIOS -\nSystem\nROM', 'ROM Flash\nFirmware Package\n- HPE ProLiant\nML350/DL360/DL\n380 Gen11 (U54)\nServers', '1', '1.46_09-\n26-2023', 'Recommended', 'U54_1.46_09_2\n6_2023.fwpkg', 'new']
['BIOS -\nSystem\nROM', 'ROM Flash\nUniversal\nFirmware Package\n- HPE ProLiant\nDL325/DL345\nGen11 (A56)\nServers', '2', '1.42_08-\n16-2023', 'Recommended', 'A56_1.42_08_1\n6_2023.fwpkg', 'new']
['BIOS -\nSystem\nROM', 'ROM Flash\nFirmware Package\n- HPE ProLiant\nDL560 Gen11\n(U59) Servers', '1', '1.46_09-\n26-2023', 'Recommended', 'U59_1.46_09_2\n6_2023.fwpkg', 'new']
['BIOS -\nSystem\nROM', 'ROM Flash\nUniversal\nFirmware Package\n- HPE ProLiant\nDL365/DL385\nGen11 (A55)\nServers', '2', '1.42_08-\n16-2023', 'Recommended', 'A55_1.42_08_1\n6_2023.fwpkg', 'new']
['Driver -\nSystem\nManagement', 'iLO 6 Automatic\nServer Recovery\nDriver for\nMicrosoft\nWindows Server\n2019', '1', '4.7.1.0 (C)', 'Optional', 'cp057238.exe', 'new']
['Driver -\nSystem\nManagement', 'iLO 6 Channel\nInterface Driver for\nMicrosoft', '1', '4.7.1.0 (C)', 'Optional', 'cp057237.exe', 'new']
--------------------------------------------------- table ---------------------------------------------------
['', 'Windows Server\n2019', '', '', '', '', '']
['Driver -\nSystem\nManagement', 'iLO 6 Channel\nInterface Driver for\nMicrosoft\nWindows Server\n2022', '1', '4.7.1.0 (C)', 'Optional', 'cp057240.exe', 'new']
['Driver -\nSystem\nManagement', 'iLO 6 Automatic\nServer Recovery\nDriver for\nMicrosoft\nWindows Server\n2022', '1', '4.7.1.0 (C)', 'Optional', 'cp057241.exe', 'new']
['Driver -\nNetwork', 'Mellanox\nConnectX-4,\nConnectX-5 and\nConnectX-6\n"nmlx5_en" Driver\nComponent for\nVMware ESXi 7.0\nUpdate 3', '3', '2022.11.09\n(A)', 'Recommended', 'cp056896.zip', 'new']
['Driver -\nNetwork', 'Intel ice Drivers\nfor Red Hat\nEnterprise Linux 8', '4', '1.11.14-1', 'Recommended', 'kmod-ice-\n1.11.14-\n1.rhel8u5.x86_6\n4.rpm\nkmod-ice-\n1.11.14-\n1.rhel8u7.x86_6\n4.rpm\nkmod-ice-\n1.11.14-\n1.rhel8u6.x86_6\n4.rpm', 'new']
['Driver -\nNetwork', 'HPE Mellanox\nRoCE (RDMA\nover Converged\nEthernet)\nConnectX-4,\nConnectX-5 and\nConnectX-6 Driver\nfor Red Hat', '2', '23.04-\n1.1.3.1', 'Recommended', 'kmod-mlnx-\nofa_kernel-\n23.04-\nOFED.23.04.1.1.\n3.1.2023062708\n14.rhel8u6.x86_\n64.rpm\nmlnx-\nofa_kernel-', 'new']
--------------------------------------------------- table ---------------------------------------------------
['', 'Enterprise Linux 8\nUpdate 6 (x86_64)', '', '', '', '23.04-\nOFED.23.04.1.1.\n3.1.rhel8u6.x86\n_64.rpm', '']
['Driver -\nNetwork', 'HPE Intel igbn\nDriver for VMware\nvSphere 8.0', '3', '2023.09.00', 'Recommended', 'cp056804.zip', 'new']
['Driver -\nNetwork', 'HPE Mellanox\nRoCE (RDMA\nover Converged\nEthernet)\nConnectX-4,\nConnectX-5 and\nConnectX-6 Driver\nfor Red Hat\nEnterprise Linux 9\nUpdate 2 (x86_64)', '1', '23.04-\n1.1.3.1', 'Recommended', 'kmod-mlnx-\nofa_kernel-\n23.04-\nOFED.23.04.1.1.\n3.1.rhel9u2.x86\n_64.rpm\nmlnx-\nofa_kernel-\n23.04-\nOFED.23.04.1.1.\n3.1.rhel9u2.x86\n_64.rpm', 'new']
['Driver -\nNetwork', 'Intel iavf Driver\nfor Windows\nServer 2019', '6', '1.13.8.0\n(C)', 'Recommended', 'cp054095.exe', 'new']
['Driver -\nNetwork', 'HPE Broadcom tg3\nEthernet Drivers\nfor Red Hat\nEnterprise Linux 9', '6', '3.139j-1\n(B)', 'Recommended', 'kmod-tg3-\n3.139j-\n1.rhel9u1.x86_6\n4.rpm\nkmod-tg3-\n3.139j-\n1.5.14.0.70.22.1\n.rhel9u0.x86_64\n.rpm', 'new']
['Driver -\nNetwork', 'HPE Mellanox\nRoCE (RDMA\nover Converged\nEthernet)\nConnectX-4,\nConnectX-5 and\nConnectX-6 Driver\nfor Red Hat\nEnterprise Linux 8\nUpdate 7 (x86_64)', '2', '23.04-\n1.1.3.1', 'Recommended', 'kmod-mlnx-\nofa_kernel-\n23.04-\nOFED.23.04.1.1.\n3.1.2023060806\n41.rhel8u7.x86_\n64.rpm\nmlnx-\nofa_kernel-\n23.04-\nOFED.23.04.1.1.', 'new']
"""