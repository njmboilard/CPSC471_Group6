import React, {useEffect, useState} from 'react'
import {useNavigate, useParams} from "react-router-dom";
// more imports needed here

const RDListPersonnel = () => {

    const [projectManager, setProjectManager] = useState([]);
    const [contractDesigners, setContractDesigners] = useState([]);
    const [inHouseDesigners, setInHouseDesigners] = useState([]);
    const [fieldStaff, setFieldStaff] = useState([]);
    const {id : projectId} = useParams();
    const [projectName, setProjectName] = useState('');

    const navigator = useNavigate();

    useEffect(() => {
        if (projectId) {
            // Insert Fetch project manager


            // Insert Fetch contract designers


            // Insert Fetch in-house designers


            // Insert Fetch field staff


            // Insert Fetch project name


            // test data to be deleted after
            const dummyProjectManager = [
                { id: 1, name: 'Jack Doe', department: 'Project Controls', pmpCertification: "True" },
              ];
            const dummyContractDesigners = [
                { id: 2, companyId: 1, name: 'Fred Flinstone' },
                { id: 3, companyId: 4, name: 'Bucky Barnes' },
                { id: 4, companyId: 3, name: 'Padme Amidala' },
              ];
            const dummyInHouseDesigners = [
                { id: 5, name: 'Mace Windu', department: 'Design', pengCertification: "True", initials: "MW" },
                { id: 6, name: 'Marty McFly', department: 'Design', pengCertification: "True", initials: "MM" },
              ];
            const dummyFieldStaff = [
                { id: 7, name: 'Tony Stark', department: 'Maintenance', position: "Maintainer" },
                { id: 8, name: 'Jean Grey', department: 'Construction', position: "Manager" },
                { id: 9, name: 'Alan Grant', department: 'Construction', position: "Wireman" },
              ];
            const dummyProjectName = "Project";


            setProjectManager(dummyProjectManager);
            setContractDesigners(dummyContractDesigners);
            setInHouseDesigners(dummyInHouseDesigners);
            setFieldStaff(dummyFieldStaff);
            setProjectName(dummyProjectName);
        }
    }, [projectId]);

    function back() {
        navigator(`/reader/projects`);
    }

    return (
        <div className='container'><br />
            <h2>{projectName} Personnel</h2>
            <button className="btn btn-dark mb-2" onClick={back}>Back</button>

            <table className='table table-striped table-bordered'>
                <caption style={{ captionSide: 'top', fontWeight: 'bold', marginBottom: '10px' }}>
                    Project Manager
                </caption>
                <thead>
                    <tr>
                        <th>Employee ID</th>
                        <th>Employee Name</th>
                        <th>Department</th>
                        <th>PMP Certification</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        projectManager.map(projectManager =>
                            <tr key={projectManager.id}>
                                <td>{projectManager.id}</td>
                                <td>{projectManager.name}</td>
                                <td>{projectManager.department}</td>
                                <td>{projectManager.pmpCertification}</td>
                            </tr>
                        )
                    }
                </tbody>
            </table>

            <table className='table table-striped table-bordered'>
                <caption style={{ captionSide: 'top', fontWeight: 'bold', marginBottom: '10px' }}>
                    Contract Designers
                </caption>
                <thead>
                    <tr>
                        <th>Contractor ID</th>
                        <th>Company ID</th>
                        <th>Contractor Name</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        contractDesigners.map(contractDesigner =>
                            <tr key={contractDesigner.id}>
                                <td>{contractDesigner.id}</td>
                                <td>{contractDesigner.companyId}</td>
                                <td>{contractDesigner.name}</td>
                            </tr>
                        )
                    }
                </tbody>
            </table>

            <table className='table table-striped table-bordered'>
                <caption style={{ captionSide: 'top', fontWeight: 'bold', marginBottom: '10px' }}>
                    In-House Designers
                </caption>
                <thead>
                    <tr>
                        <th>Employee ID</th>
                        <th>Employee Name</th>
                        <th>Department</th>
                        <th>P.Eng Certification</th>
                        <th>Initials</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        inHouseDesigners.map(inHouseDesigner =>
                            <tr key={inHouseDesigner.id}>
                                <td>{inHouseDesigner.id}</td>
                                <td>{inHouseDesigner.name}</td>
                                <td>{inHouseDesigner.department}</td>
                                <td>{inHouseDesigner.pengCertification}</td>
                                <td>{inHouseDesigner.initials}</td>
                            </tr>
                        )
                    }
                </tbody>
            </table>

            <table className='table table-striped table-bordered'>
                <caption style={{ captionSide: 'top', fontWeight: 'bold', marginBottom: '10px' }}>
                    Field Staff
                </caption>
                <thead>
                    <tr>
                        <th>Employee ID</th>
                        <th>Employee Name</th>
                        <th>Department</th>
                        <th>Position</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        fieldStaff.map(fieldStaff =>
                            <tr key={fieldStaff.id}>
                                <td>{fieldStaff.id}</td>
                                <td>{fieldStaff.name}</td>
                                <td>{fieldStaff.department}</td>
                                <td>{fieldStaff.position}</td>
                            </tr>
                        )
                    }
                </tbody>
            </table>
        </div>
    )
};

export default RDListPersonnel;