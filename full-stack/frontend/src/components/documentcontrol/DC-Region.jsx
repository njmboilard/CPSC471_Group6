import React, {useEffect, useState} from 'react'
import {createRegion, getRegion, updateRegion} from "../../services/RegionService.js";
import {useNavigate, useParams} from "react-router-dom";

const DCRegion = () => {
	const [name, setName] = useState('')

	const {id} = useParams();

	const [errors, setErrors] = useState({
		name: ''
	})

	const navigator = useNavigate();

	useEffect(() => {
		if(id) {
			getRegion(id).then((response) => {
				setName(response.data.name);
			}).catch(error => {
				console.error(error);
			})
		}
	}, [id])

	function saveOrUpdateRegion(e) {
		e.preventDefault();

		if (validateForm()) {

			const region = {name}
			console.log(region)

			if (id) {
				// update region
				updateRegion(id, region).then((response) => {
					console.log(response.data);
					navigator('/documentcontrol/regions');
				}).catch(error => {
					console.error(error);
				})
			} else {
				// add region
				createRegion(region).then((response) => {
					console.log(response.data);
					navigator('/documentcontrol/regions');
				}).catch(errors => {
					console.error(errors);
				})
			}
		}
	}

	function validateForm() {
		let valid = true;
		const errorsCopy = {... errors}

		if (name.trim()) {
			errorsCopy.name = '';
		} else {
			errorsCopy.name = 'Region name is required';
			valid = false;
		}

		setErrors(errorsCopy);
		return valid;
	}

	function pageTitle() {
		if (id) {
			return <h2>Update Region</h2>
		} else {
			return <h2>Add Region</h2>
		}
	}

	return (
		<div className="container">
			<br/><br/><br/>
			<div className="row">
				<div className="card col-md-6 offset-md-3 offset-md-3">
					{pageTitle()}
					<div className="card-body">
						<form>
							<div className="form-group mb-2">
								<label className="form-label">Name</label>
								<input
									type="text"
									placeholder="Name"
									name="name"
									value={name}
									className={`form-control ${errors.name ? 'is-invalid' : ''}`}
									onChange={(e) => setName(e.target.value)}
								>
								</input>
								{errors.name && <div className="invalid-feedback">{errors.name}</div>}
							</div>

							<button className="btn btn-dark mb-2" onClick={saveOrUpdateRegion}>Submit</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	)
}
export default DCRegion
