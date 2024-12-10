import React, {useEffect, useState} from 'react'
import {useNavigate} from "react-router-dom";
import {deleteProject, listProjects} from "../../services/ProjectService.js";

const DCListProject = () => {

	const [projects, setProjects] = useState([])

	const navigator = useNavigate();

	useEffect(() => {
		getAllProjects();
	}, [])

	function getAllProjects() {
		//listProjects().then((response) => {
		//	setProjects(response.data);
		//}).catch(error => {
		//	console.log(error);
		//})

		// test data to be deleted after
		const dummyProjects = [
			{ id: 1, year: 2024, name: "BELL001.43 - Gate Replacement", status: "Active", dlEmployeeId: "GRE0023" },
			{ id: 2, year: 2024, name: "ELLA121.58 - Switch Upgrade", status: "Active", dlEmployeeId: "POW0111" },
			{ id: 3, year: 2024, name: "REDE001.21 - Relay Replacement", status: "Active", dlEmployeeId: "KET0031" },
		];
		setProjects(dummyProjects);
	}

	function back() {
		navigator('/documentcontrol');
	}

    function addNewProject() {
		navigator(`/documentcontrol/projects/add`);
	}

	function updateProject(projectId) {
		navigator(`/documentcontrol/projects/update/${projectId}`);
	}

	function removeProject(projectId) {
		console.log(projectId);

		deleteProject(projectId).then((response) => {
			getAllProjects();
		}).catch(error => {
			console.error(error);
		})
	}

    function personnel(projectId) {
		console.log(projectId);
		navigator(`/documentcontrol/projects/${projectId}/personnel`);
	}

	function assignedPlan(projectId) {
		console.log(projectId);
		navigator(`/documentcontrol/projects/${projectId}/assignedplans`);
	}

    function issues(projectId) {
		console.log(projectId);
		navigator(`/documentcontrol/projects/${projectId}/issues`);
	}

	return (
		<div className='container'><br/>
			<h2>Projects</h2>
            <button className="btn btn-dark mb-2" onClick={addNewProject}>Add Project</button>
			<button className="btn btn-dark mb-2" onClick={back} style={{ marginLeft: '10px' }}>Back</button>
			<table className='table table-striped table-bordered'>
				<thead>
					<tr>
						<th>Project ID</th>
						<th>Year</th>
						<th>Project Name</th>
                        <th>Project Status</th>
                        <th>DL Employee ID</th>
                        <th>Actions</th>
					</tr>
				</thead>
				<tbody>
				{
					projects.map(project =>
						<tr key={project.id}>
							<td>{project.id}</td>
                            <td>{project.year}</td>
							<td>{project.name}</td>
                            <td>{project.status}</td>
                            <td>{project.dlEmployeeId}</td>
							<td>
                                <button className="btn btn-dark" onClick={() => updateProject(project.id)}>Update</button>
								<button
									className="btn btn-dark"
									onClick={() => {
										if (window.confirm("Are you sure you want to delete project " + project.id + "?")) {
											removeProject(project.id);
										}
									}}
									style={{marginLeft: '10px'}}
								>
									Delete
								</button>
                                <button className="btn btn-dark" onClick={() => personnel(project.id)}
                                    style={{marginLeft: '10px'}}>Personnel
                                </button>
								<button className="btn btn-dark" onClick={() => assignedPlan(project.id)}
                                    style={{marginLeft: '10px'}}>Assigned Plans
                                </button>
                                <button className="btn btn-dark" onClick={() => issues(project.id)}
                                    style={{marginLeft: '10px'}}>Issues
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
export default DCListProject