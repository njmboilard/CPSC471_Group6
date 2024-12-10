import React, {useEffect, useState} from 'react'
import {useNavigate, useParams} from "react-router-dom";
import {createProject, getProject, updateProject} from "../../services/ProjectService.js";
// more imports needed here

const DCProject = () => {
	const [projectYear, setProjectYear] = useState('')
	const [projectName, setProjectName] = useState('')
    const [projectStatus, setProjectStatus] = useState('')
    const [projectDLEmployeeID, setProjectDLEmployeeID] = useState('')
	const {id : projectId} = useParams();

	const [errors, setErrors] = useState({
		projectYear: '',
		projectName: '',
        projectStatus: '',
        projectDLEmployeeID: ''
	})

	const navigator = useNavigate();

	useEffect(() => {
		if(projectId) {
			getProject(projectId).then((response) => {
				setProjectYear(response.data.year);
				setProjectName(response.data.projectName);
                setProjectStatus(response.data.projectStatus);
				setProjectDLEmployeeID(response.data.designLead.employeeId);
			}).catch(error => {
				console.error(error);
			})
		}
	}, [projectId])

	function saveOrUpdateProject(e) {
		e.preventDefault();

		if (validateForm()) {

			const project = {
				year: projectYear,
				projectName: projectName,
				projectStatus: projectStatus,
				designLead: {
					employeeId: parseInt(projectDLEmployeeID, 10),
				},
			};
			console.log(project)

			if (projectId) {
				// update project
                updateProject(projectId, project).then((response) => {
					console.log(response.data);
					navigator("/documentcontrol/projects");
				}).catch(error => {
					console.error(error);
				})
			} else {
				// add project
				createProject(project).then((response) => {
					console.log(response.data);
					navigator("/documentcontrol/projects");
				}).catch(errors => {
					console.error(errors);
				})
			}
		}
	}

	function validateForm() {
		let valid = true;
		const errorsCopy = {... errors}

		if (projectYear.trim()) {
			errorsCopy.projectYear = '';
		} else {
			errorsCopy.projectYear = 'Project Year is required';
			valid = false;
		}

		if (projectName.trim()) {
			errorsCopy.projectName = '';
		} else {
			errorsCopy.projectName = 'Project Name is required';
			valid = false;
		}

        if (projectStatus.trim()) {
			errorsCopy.projectStatus = '';
		} else {
			errorsCopy.projectStatus = 'Project Status is required';
			valid = false;
		}

        if (projectDLEmployeeID.trim()) {
			errorsCopy.projectDLEmployeeID = '';
		} else {
			errorsCopy.projectDLEmployeeID = 'Project DL Employee ID is required';
			valid = false;
		}

		setErrors(errorsCopy);
		return valid;
	}

	function pageTitle() {
		if (projectId) {
			return <h2>Update Project</h2>
		} else {
			return <h2>Add Project</h2>
		}
	}

	function back(e) {
		e.preventDefault();
		navigator("/documentcontrol/projects");
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
								<label className="form-label">Year</label>
								<input
									type="text"
									placeholder="Year"
									name="year"
									value={projectYear}
									className={`form-control ${errors.projectYear ? 'is-invalid' : ''}`}
									onChange={(e) => setProjectYear(e.target.value)}
								>
								</input>
								
								{errors.projectYear && <div className="invalid-feedback">{errors.projectYear}</div>}
							</div>
							<div className="form-group mb-3">
								<label className="form-label">Project Name</label>
								<input
									type="text"
									placeholder="Project Name"
									name="projectName"
									value={projectName}
									className={`form-control ${errors.projectName ? 'is-invalid' : ''}`}
									onChange={(e) => setProjectName(e.target.value)}
								>
								</input>
								
								{errors.projectName && <div className="invalid-feedback">{errors.projectName}</div>}
							</div>
                            <div className="form-group mb-3">
								<label className="form-label">Project Status</label>
								<input
									type="text"
									placeholder="Project Status"
									name="projectStatus"
									value={projectStatus}
									className={`form-control ${errors.projectStatus ? 'is-invalid' : ''}`}
									onChange={(e) => setProjectStatus(e.target.value)}
								>
								</input>
								
								{errors.projectStatus && <div className="invalid-feedback">{errors.projectStatus}</div>}
							</div>
                            <div className="form-group mb-3">
								<label className="form-label">Project Design Lead Employee ID</label>
								<input
									type="text"
									placeholder="Project DL Employee ID"
									name="dlEmployeeId" // idk if this name is right
									value={projectDLEmployeeID}
									className={`form-control ${errors.projectDLEmployeeID ? 'is-invalid' : ''}`}
									onChange={(e) => setProjectDLEmployeeID(e.target.value)}
								>
								</input>
								
								{errors.projectDLEmployeeID && <div className="invalid-feedback">{errors.projectDLEmployeeID}</div>}
							</div>
							<button className="btn btn-dark mb-2" onClick={saveOrUpdateProject}>Submit</button>
							<button className="btn btn-dark mb-2" onClick={back} style={{ marginLeft: '10px' }}>Back</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	)
}
export default DCProject