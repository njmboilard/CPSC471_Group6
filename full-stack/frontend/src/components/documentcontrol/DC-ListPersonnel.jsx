import React, {useEffect, useState} from 'react'
import {useNavigate, useParams} from "react-router-dom";
// more imports needed here

const DCListPersonnel = () => {

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
        navigator(`/documentcontrol/projects`);
    }

    function addNewProjectManager() {
		navigator(`/documentcontrol/projects/${projectId}/personnel/add/projectmanager`);
	}

    function updateProjectManager(employeeID) {
		navigator(`/documentcontrol/projects/${projectId}/personnel/update/projectmanager/${employeeID}`);
    }

	function removeProjectManager(employeeID) {
		console.log(employeeID);

		// remove issue logic here
	}

    function addNewContractDesigner() {
		navigator(`/documentcontrol/projects/${projectId}/personnel/add/contractdesigner`);
	}

    function updateContractDesigner(contractorID) {
		navigator(`/documentcontrol/projects/${projectId}/personnel/update/contractdesigner/${contractorID}`);
	}

	function removeContractDesigner(contractorID) {
		console.log(contractorID);

		// remove issue logic here
	}

    function addNewInHouseDesigner() {
		navigator(`/documentcontrol/projects/${projectId}/personnel/add/inhousedesigner`);
	}

    function updateInHouseDesigner(employeeID) {
		navigator(`/documentcontrol/projects/${projectId}/personnel/update/inhousedesigner/${employeeID}`);
	}

	function removeInHouseDesigner(employeeID) {
		console.log(employeeID);

		// remove issue logic here
	}

    function addNewFieldStaff() {
		navigator(`/documentcontrol/projects/${projectId}/personnel/add/fieldstaff`);
	}

    function updateFieldStaff(employeeID) {
		navigator(`/documentcontrol/projects/${projectId}/personnel/update/fieldstaff/${employeeID}`);
	}

	function removeFieldStaff(employeeID) {
		console.log(employeeID);

		// remove issue logic here
	}

    return (
        <div className='container'><br />
            <h2>{projectName} Personnel</h2>

            <button className="btn btn-dark mb-2" onClick={addNewProjectManager}>Add Project Manager</button>
            <button className="btn btn-dark mb-2" onClick={addNewContractDesigner} style={{ marginLeft: '10px' }}>Add Contract Designer</button>
            <button className="btn btn-dark mb-2" onClick={addNewInHouseDesigner} style={{ marginLeft: '10px' }}>Add In-House Designer</button>
            <button className="btn btn-dark mb-2" onClick={addNewFieldStaff} style={{ marginLeft: '10px' }}>Add Field Staff</button>
            <button className="btn btn-dark mb-2" onClick={back} style={{ marginLeft: '10px' }}>Back</button>

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
                        <th style={{ width: '250px' }}>Actions</th>
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
                                <td>
                                    <button className="btn btn-dark" onClick={() => updateProjectManager(projectManager.id)}>Update</button>
								    <button
								    	className="btn btn-dark"
								    	onClick={() => {
								    		if (window.confirm("Are you sure you want to delete Project Manager with ID: " + projectManager.id + "?")) {
								    			removeProjectManager(projectManager.id);
								    		}
								    	}}
								    	style={{marginLeft: '10px'}}
								    >
								    	Delete
								    </button>
							    </td>
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
                        <th style={{ width: '250px' }}>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        contractDesigners.map(contractDesigner =>
                            <tr key={contractDesigner.id}>
                                <td>{contractDesigner.id}</td>
                                <td>{contractDesigner.companyId}</td>
                                <td>{contractDesigner.name}</td>
                                <td>
                                    <button className="btn btn-dark" onClick={() => updateContractDesigner(contractDesigner.id)}>Update</button>
								    <button
								    	className="btn btn-dark"
								    	onClick={() => {
								    		if (window.confirm("Are you sure you want to delete Contract Designer with ID: " + contractDesigner.id + "?")) {
								    			removeContractDesigner(contractDesigner.id);
								    		}
								    	}}
								    	style={{marginLeft: '10px'}}
								    >
								    	Delete
								    </button>
							    </td>
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
                        <th style={{ width: '250px' }}>Actions</th>
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
                                <td>
                                    <button className="btn btn-dark" onClick={() => updateInHouseDesigner(inHouseDesigner.id)}>Update</button>
								    <button
								    	className="btn btn-dark"
								    	onClick={() => {
								    		if (window.confirm("Are you sure you want to delete In-House Designer with ID: " + inHouseDesigner.id + "?")) {
								    			removeInHouseDesigner(inHouseDesigner.id);
								    		}
								    	}}
								    	style={{marginLeft: '10px'}}
								    >
								    	Delete
								    </button>
							    </td>
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
                        <th style={{ width: '250px' }}>Actions</th>
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
                                <td>
                                    <button className="btn btn-dark" onClick={() => updateFieldStaff(fieldStaff.id)}>Update</button>
								    <button
								    	className="btn btn-dark"
								    	onClick={() => {
								    		if (window.confirm("Are you sure you want to delete Field Staff member with ID: " + fieldStaff.id + "?")) {
								    			removeFieldStaff(fieldStaff.id);
								    		}
								    	}}
								    	style={{marginLeft: '10px'}}
								    >
								    	Delete
								    </button>
                                </td>
                            </tr>
                        )
                    }
                </tbody>
            </table>
        </div>
    )
}

export default DCListPersonnel;