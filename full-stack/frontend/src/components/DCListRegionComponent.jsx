import React, {useEffect, useState} from 'react'
import {deleteRegion, listRegions} from "../services/RegionService.js";
import {useNavigate} from "react-router-dom";

const DCListRegionComponent = () => {

	const [regions, setRegions] = useState([])

	const navigator = useNavigate();

	useEffect(() => {
		getAllRegions();
	}, [])

	function getAllRegions() {
		listRegions().then((response) => {
			setRegions(response.data);
		}).catch(error => {
			console.log(error);
		})
	}

	function addNewRegion() {
		navigator('/add-region')
	}

	function updateRegion(id) {
		navigator(`/update-region/${id}`)
	}

	function removeRegion(id) {
		console.log(id);

		deleteRegion(id).then((response) => {
			getAllRegions();
		}).catch(error => {
			console.error(error);
		})
	}

	return (
		<div className='container'>
			<br/>
			<h2>Regions</h2>
			<button className="btn btn-dark mb-2" onClick={addNewRegion}>Add Region</button>
			<table className='table table-striped table-bordered'>
				<thead>
					<tr>
						<th>Region ID</th>
						<th>Region Name</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					{
						regions.map(region =>
							<tr key={region.id}>
								<td>{region.id}</td>
								<td>{region.name}</td>
								<td>
									<button className="btn btn-dark" onClick={() => updateRegion(region.id)}>Update</button>
									<button className="btn btn-dark" onClick={() => removeRegion(region.id)} style={{marginLeft:'10px'}}>Delete</button>
								</td>
							</tr>
						)
					}
				</tbody>
			</table>
		</div>
	)
}
export default DCListRegionComponent
