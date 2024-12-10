import React, {useEffect, useState} from 'react'
import {useNavigate, useParams} from "react-router-dom";
// more imports needed here

const DCInHouseDesigner = () => {

    const {id : projectId, ihdid : inHouseDesignerId} = useParams();

    const [ihdEmployeeName, setIHDEmployeeName] = useState('')
	const [ihdEmployeeDepartment, setIHDEmployeeDepartment] = useState('')
    const [ihdEmployeePENG, setIHDEmployeePENG] = useState('')
    const [ihdEmployeeInitials, setIHDEmployeeInitials] = useState('')

	const [errors, setErrors] = useState({
	    ihdEmployeeName: '',
		ihdEmployeeDepartment: '',
        ihdEmployeePENG: '',
        ihdEmployeeInitials: ''
	})

	const navigator = useNavigate();

	useEffect(() => {
		// commented out since getInHouseDesigner does not exist yet

		//if(inHouseDesignerId) {
		//	getInHouseDesigner(inHouseDesignerId).then((response) => {
        //      setIHDEmployeeName(response.data.ihdEmployeeName);
		//		setIHDEmployeeDepartment(response.data.ihdEmployeeDepartment);
        //      setIHDEmployeePENG(response.data.ihdEmployeePENG);
        //      setIHDEmployeeInitials(response.data.ihdEmployeeInitials);
		//	}).catch(error => {
		//		console.error(error);
		//	})
		//}
	}, [inHouseDesignerId])

	function saveOrUpdateInHouseDesigner(e) {
		e.preventDefault();

		if (validateForm()) {
            
            const inHouseDesigner = {inHouseDesignerId, ihdEmployeeName, ihdEmployeeDepartment, ihdEmployeePENG, ihdEmployeeInitials}

			console.log(issue)

			if (inHouseDesignerId) {
				// update in-house designer

				//updateInHouseDesigner( (?) ).then((response) => {
				//	console.log(response.data);
				//	navigator(`/documentcontrol/projects/${projectId}/personnel`);
				//}).catch(error => {
				//	console.error(error);
				//})
			} else {
				// add in house designer

				//createInHouseDesigner( (?) ).then((response) => {
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

		if (ihdEmployeeName.trim()) {
			errorsCopy.ihdEmployeeName = '';
		} else {
			errorsCopy.ihdEmployeeName = 'Employee Name is required';
			valid = false;
		}

		if (ihdEmployeeDepartment.trim()) {
			errorsCopy.ihdEmployeeDepartment = '';
		} else {
			errorsCopy.ihdEmployeeDepartment = 'Employee Department is required';
			valid = false;
		}

        if (ihdEmployeePENG.trim()) {
			errorsCopy.ihdEmployeePENG = '';
		} else {
			errorsCopy.ihdEmployeePENG = 'Employee P.Eng Certification is required';
			valid = false;
		}

        if (ihdEmployeeInitials.trim()) {
			errorsCopy.ihdEmployeeInitials = '';
		} else {
			errorsCopy.ihdEmployeeInitials = 'Employee Initials are required';
			valid = false;
		}

		setErrors(errorsCopy);
		return valid;
	}

	function pageTitle() {
		if (inHouseDesignerId) {
			return <h2>Update In-House Designer</h2>
		} else {
			return <h2>Add In-House Designer</h2>
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
								<label className="form-label">In-House Designer Employee Name</label>
								<input
									type="text"
									placeholder="Employee Name"
									name="employeeName"
									value={ihdEmployeeName}
									className={`form-control ${errors.ihdEmployeeName ? 'is-invalid' : ''}`}
									onChange={(e) => setIHDEmployeeName(e.target.value)}
								>
								</input>
								
								{errors.ihdEmployeeName && <div className="invalid-feedback">{errors.ihdEmployeeName}</div>}
							</div>
							<div className="form-group mb-3">
								<label className="form-label">In-House Designer Employee Department</label>
								<input
									type="text"
									placeholder="Employee Department"
									name="department"
									value={ihdEmployeeDepartment}
									className={`form-control ${errors.ihdEmployeeDepartment ? 'is-invalid' : ''}`}
									onChange={(e) => setIHDEmployeeDepartment(e.target.value)}
								>
								</input>
								
								{errors.ihdEmployeeDepartment && <div className="invalid-feedback">{errors.ihdEmployeeDepartment}</div>}
							</div>
                            <div className="form-group mb-3">
								<label className="form-label">In-House Designer Employee P.Eng Certification</label>
								<input
									type="text"
									placeholder="Employee P.Eng Certification"
									name="pengCertification"
									value={ihdEmployeePENG}
									className={`form-control ${errors.ihdEmployeePENG ? 'is-invalid' : ''}`}
									onChange={(e) => setIHDEmployeePENG(e.target.value)}
								>
								</input>
								
								{errors.ihdEmployeePENG && <div className="invalid-feedback">{errors.ihdEmployeePENG}</div>}
							</div>
                            <div className="form-group mb-3">
								<label className="form-label">In-House Designer Employee P.Eng Certification</label>
								<input
									type="text"
									placeholder="Employee Initials"
									name="initials"
									value={ihdEmployeeInitials}
									className={`form-control ${errors.ihdEmployeeInitials ? 'is-invalid' : ''}`}
									onChange={(e) => setIHDEmployeeInitials(e.target.value)}
								>
								</input>
								
								{errors.ihdEmployeeInitials && <div className="invalid-feedback">{errors.ihdEmployeeInitials}</div>}
							</div>
							<button className="btn btn-dark mb-2" onClick={saveOrUpdateInHouseDesigner}>Submit</button>
							<button className="btn btn-dark mb-2" onClick={back} style={{ marginLeft: '10px' }}>Back</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	)
}
export default DCInHouseDesigner