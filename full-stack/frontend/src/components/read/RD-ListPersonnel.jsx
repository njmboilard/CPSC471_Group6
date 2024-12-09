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


            // test data to be deleted after
            const dummyProjectManager = [
                { id: 1, name: 'Julius Caesar', department: 'idk roman probably', pmpCertification: "no" },
              ];
            const dummyContractDesigners = [
                { id: 2, companyId: 1, name: 'Leonardo Da Vinci' },
                { id: 3, companyId: 5, name: 'Tony Gonzalez' },
                { id: 4, companyId: 9001, name: 'Bob Barker' },
              ];
            const dummyInHouseDesigners = [
                { id: 5, name: 'Tony Roma', department: 'ribs', pengCertification: "yes", initials: "TR" },
                { id: 6, name: 'God Zilla', department: 'doom', pengCertification: "yes", initials: "GZ" },
              ];
            const dummyFieldStaff = [
                { id: 7, name: 'Zeus', department: 'building stuff', position: "railway guru" },
                { id: 8, name: 'Bob the Builder', department: 'building stuff', position: "god of railway" },
                { id: 9, name: 'Dwight', department: 'building stuff', position: "assistant to the railway guru" },
              ];
            const dummyProjectName = "Dummy Project";


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