import React, {useEffect, useState} from 'react'
import {listRegions} from "../services/RegionService.js";

const ListRegionComponent = () => {

	const [regions, setRegions] = useState([])

	useEffect(() => {
		listRegions().then((response) => {
			setRegions(response.data);
		}).catch(error => {
			console.log(error);
		})
	}, [])

	return (
		<div className='container'>
			<h2>Regions</h2>
			<table className='table table-striped table-bordered'>
				<thead>
					<tr>
						<th>Region ID</th>
						<th>Region Name</th>
					</tr>
				</thead>
				<tbody>
					{
						regions.map(region =>
							<tr key={region.id}>
								<td>{region.id}</td>
								<td>{region.name}</td>
							</tr>
						)
					}
				</tbody>
			</table>
		</div>
	)
}
export default ListRegionComponent
