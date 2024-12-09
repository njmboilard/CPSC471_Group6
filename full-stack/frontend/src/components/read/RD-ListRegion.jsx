import React, {useEffect, useState} from 'react'
import {useNavigate} from "react-router-dom";
import {listRegions} from "../../services/RegionService.js";

const RdListRegion = () => {

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

		// test data to be deleted after
		// const dummyRegions = [
		// 	{ id: 1, name: "Canada" },
		// 	{ id: 2, name: "Utah" },
		// 	{ id: 3, name: "Soviet Russia"},
		// ];
		// setRegions(dummyRegions);
	}

	function back() {
		navigator('/reader');
	}

	function subdivision(regionId) {
		console.log(regionId);
		navigator(`/reader/regions/${regionId}/subdivisions`);
	}

	return (
		<div className='container'><br/>
			<h2>Regions</h2>
			<button className="btn btn-dark mb-2" onClick={back}>Back</button>
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
								<button className="btn btn-dark" onClick={() => subdivision(region.id)}>Subdivisions</button>
							</td>
						</tr>
					)
				}
				</tbody>
			</table>
		</div>
	)
}
export default RdListRegion
