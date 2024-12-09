import React, {useEffect, useState} from 'react'
import {useNavigate, useParams} from "react-router-dom";
// more imports needed here

const DCProjectManager = () => {

    const {id : projectId, pmid : projectManagerId} = useParams();

    const [pmEmployeeName, setPMEmployeeName] = useState('')
	const [pmEmployeeDepartment, setPMEmployeeDepartment] = useState('')
    const [pmEmployeePMP, setPMEmployeePMP] = useState('')

	const [errors, setErrors] = useState({
	    pmEmployeeName: '',
	    pmEmployeeDepartment: '',
        pmEmployeePMP: ''
	})

	const navigator = useNavigate();

	useEffect(() => {
		// commented out since getProjectManager does not exist yet

		//if(projectManagerId) {
		//	getProjectManager(projectManagerId).then((response) => {
        //      setPMEmployeeName(response.data.pmEmployeeName);
		//		setPMEmployeeDepartment(response.data.pmEmployeeDepartment);
        //      setPMEmployeePMP(response.data.pmEmployeePMP);
		//	}).catch(error => {
		//		console.error(error);
		//	})
		//}
	}, [projectManagerId])

	function saveOrUpdateProjectManager(e) {
		e.preventDefault();

		if (validateForm()) {
            
            const projectManager = {projectManagerId, pmEmployeeName, pmEmployeeDepartment, pmEmployeePMP}

			console.log(issue)

			if (projectManagerId) {
				// update project manager

				// commented out since updateProjectManager does not exist yet
				// not sure about parameters hence the (?)

				//updateProjectManager( (?) ).then((response) => {
				//	console.log(response.data);
				//	navigator(`/documentcontrol/projects/${projectId}/personnel`);
				//}).catch(error => {
				//	console.error(error);
				//})
			} else {
				// add project manager

				// commented out since createProjectManager does not exist yet
				// not sure about parameters hence the (?)

				//createProjectManager( (?) ).then((response) => {
				//	console.log(response.data);
				//	navigator(`/documentcontrol/projects/${projectId}/personnel`);
				//}).catch(errors => {
				//	console.error(errors);
				//})
			}
		}
	}

	function validateForm() {
		let valid = true;
		const errorsCopy = {... errors}

		if (pmEmployeeName.trim()) {
			errorsCopy.pmEmployeeName = '';
		} else {
			errorsCopy.pmEmployeeName = 'Employee Name is required';
			valid = false;
		}

		if (pmEmployeeDepartment.trim()) {
			errorsCopy.pmEmployeeDepartment = '';
		} else {
			errorsCopy.pmEmployeeDepartment = 'Employee Department is required';
			valid = false;
		}

        if (pmEmployeePMP.trim()) {
			errorsCopy.pmEmployeePMP = '';
		} else {
			errorsCopy.pmEmployeePMP = 'Employee PMP Certification is required';
			valid = false;
		}

		setErrors(errorsCopy);
		return valid;
	}

	function pageTitle() {
		if (projectManagerId) {
			return <h2>Update Project Manager</h2>
		} else {
			return <h2>Add Project Manager</h2>
		}
	}

	function back(e) {
		e.preventDefault();
		navigator(`/documentcontrol/projects/${projectId}/personnel`);
	}

	return (
		<div className="container">
			<br/><br/><br/>
			<div className="row">
				<div className="card col-md-6 offset-md-3 offset-md-3">
					{pageTitle()}
					<div className="card-body">
						<form>
							<div className="form-group mb-3">
								<label className="form-label">Project Manager Employee Name</label>
								<input
									type="text"
									placeholder="Employee Name"
									name="employeeName"
									value={pmEmployeeName}
									className={`form-control ${errors.pmEmployeeName ? 'is-invalid' : ''}`}
									onChange={(e) => setPMEmployeeName(e.target.value)}
								>
								</input>
								
								{errors.pmEmployeeName && <div className="invalid-feedback">{errors.pmEmployeeName}</div>}
							</div>
							<div className="form-group mb-3">
								<label className="form-label">Project Manager Employee Department</label>
								<input
									type="text"
									placeholder="Employee Department"
									name="department"
									value={pmEmployeeDepartment}
									className={`form-control ${errors.pmEmployeeDepartment ? 'is-invalid' : ''}`}
									onChange={(e) => setPMEmployeeDepartment(e.target.value)}
								>
								</input>
								
								{errors.pmEmployeeDepartment && <div className="invalid-feedback">{errors.pmEmployeeDepartment}</div>}
							</div>
                            <div className="form-group mb-3">
								<label className="form-label">Project Manager Employee PMP Certification</label>
								<input
									type="text"
									placeholder="Employee PMP Certification"
									name="pmpCertification"
									value={pmEmployeePMP}
									className={`form-control ${errors.pmEmployeePMP ? 'is-invalid' : ''}`}
									onChange={(e) => setPMEmployeePMP(e.target.value)}
								>
								</input>
								
								{errors.pmEmployeePMP && <div className="invalid-feedback">{errors.pmEmployeePMP}</div>}
							</div>
							<button className="btn btn-dark mb-2" onClick={saveOrUpdateProjectManager}>Submit</button>
							<button className="btn btn-dark mb-2" onClick={back} style={{ marginLeft: '10px' }}>Back</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	)
}
export default DCProjectManager