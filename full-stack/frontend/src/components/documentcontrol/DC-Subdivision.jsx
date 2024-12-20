import React, {useEffect, useState} from 'react'
import {useNavigate, useParams} from "react-router-dom";
import {createSubdivision, getSubdivision, updateSubdivision} from "../../services/RegionService.js";

const DCSubdivision = () => {
	const [subdivisionChopCode, setSubdivisionChopCode] = useState('')
	const [subdivisionName, setSubdivisionName] = useState('')
	const {id : regionId, chopcode : chopCode} = useParams();

	const [errors, setErrors] = useState({
		subdivisionChopCode: '',
		subdivisionName: ''
	})

	const navigator = useNavigate();

	useEffect(() => {
		if(chopCode) {
			getSubdivision(regionId, chopCode).then((response) => {
				setSubdivisionChopCode(response.data.chopCode);
				setSubdivisionName(response.data.name);
			}).catch(error => {
				console.error(error);
			})
		}
	}, [regionId, chopCode])

	function saveOrUpdateSubdivision(e) {
		e.preventDefault();

		if (validateForm()) {

			const subdivision = {
				chopCode: subdivisionChopCode,
				name: subdivisionName
			}
			console.log(subdivision)

			if (chopCode) {
				// update subdivision
				updateSubdivision(regionId, chopCode, subdivision).then((response) => {
					console.log(response.data);
					navigator(`/documentcontrol/regions/${regionId}/subdivisions`);
				}).catch(error => {
					console.error(error);
				})
			} else {
				// add subdivision
				createSubdivision(regionId, subdivision).then((response) => {
					console.log(response.data);
					navigator(`/documentcontrol/regions/${regionId}/subdivisions`);
				}).catch(errors => {
					console.error(errors);
				})
			}
		}
	}

	function validateForm() {
		let valid = true;
		const errorsCopy = {... errors}

		if (subdivisionChopCode.trim()) {
			errorsCopy.subdivisionChopCode = '';
		} else {
			errorsCopy.subdivisionChopCode = 'CHOP Code is required';
			valid = false;
		}

		if (subdivisionName.trim()) {
			errorsCopy.subdivisionName = '';
		} else {
			errorsCopy.subdivisionName = 'Subdivision Name is required';
			valid = false;
		}

		setErrors(errorsCopy);
		return valid;
	}

	function pageTitle() {
		if (chopCode) {
			return <h2>Update Subdivision</h2>
		} else {
			return <h2>Add Subdivision</h2>
		}
	}

	function back(e) {
		e.preventDefault();
		navigator(`/documentcontrol/regions/${regionId}/subdivisions`);
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
								<label className="form-label">CHOP Code</label>
								<input
									type="text"
									placeholder="CHOP Code"
									name="chopCode"
									value={subdivisionChopCode}
									className={`form-control ${errors.subdivisionChopCode ? 'is-invalid' : ''}`}
									onChange={(e) => setSubdivisionChopCode(e.target.value)}
								>
								</input>
								
								{errors.subdivisionChopCode && <div className="invalid-feedback">{errors.subdivisionChopCode}</div>}
							</div>
							<div className="form-group mb-3">
								<label className="form-label">Subdivision Name</label>
								<input
									type="text"
									placeholder="Subdivision Name"
									name="subdivisionName"
									value={subdivisionName}
									className={`form-control ${errors.subdivisionName ? 'is-invalid' : ''}`}
									onChange={(e) => setSubdivisionName(e.target.value)}
								>
								</input>
								
								{errors.subdivisionName && <div className="invalid-feedback">{errors.subdivisionName}</div>}
							</div>
							<button className="btn btn-dark mb-2" onClick={saveOrUpdateSubdivision}>Submit</button>
							<button className="btn btn-dark mb-2" onClick={back} style={{ marginLeft: '10px' }}>Back</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	)
}
export default DCSubdivision
